package modules.admin.DocumentCreator.actions;

import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlRenderer;
import org.skyve.domain.messages.Message;
import org.skyve.domain.messages.ValidationException;
import org.skyve.impl.metadata.repository.document.DocumentMetaData;
import org.skyve.impl.metadata.repository.module.ModuleMetaData;
import org.skyve.impl.script.SkyveScriptException;
import org.skyve.impl.script.SkyveScriptInterpreter;
import org.skyve.impl.util.XMLMetaData;
import org.skyve.metadata.controller.ServerSideAction;
import org.skyve.metadata.controller.ServerSideActionResult;
import org.skyve.web.WebContext;

import modules.admin.domain.DocumentCreator;

public class UpdatePreview implements ServerSideAction<DocumentCreator> {

	private static final long serialVersionUID = -682204740567953097L;

	@Override
	@SuppressWarnings("boxing")
	public ServerSideActionResult<DocumentCreator> execute(DocumentCreator bean, WebContext webContext) throws Exception {
		String script = bean.getScript();
		if (script == null) {
			bean.setMarkdownPreview(null);
			bean.setDocumentPreview(null);
		}
		else {
			SkyveScriptInterpreter i = new SkyveScriptInterpreter(bean.getScript(), bean.getDefaultModule());
			i.preProcess();
			Node document = i.parse();

			// Parser parser = Parser.builder().build();
			// Node document = parser.parse(script);
	
			// create a markdown to HTML renderer for the markdown preview tab
			HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
	
			// create a markdown to document XML renderer for the document preview tab
			/*HtmlRenderer documentRenderer = HtmlRenderer.builder().nodeRendererFactory(new HtmlNodeRendererFactory() {
				@Override
				public NodeRenderer create(HtmlNodeRendererContext context) {
					return new SkyveDocumentNodeRenderer(context, true);
				}
			}).build();*/
	
			// update the previews
			bean.setMarkdownPreview(htmlRenderer.render(document));
			// bean.setDocumentPreview(documentRenderer.render(document));

			i.process();
			if (i.getModules().size() > 0) {
				StringBuilder out = new StringBuilder();
				for (ModuleMetaData m : i.getModules()) {
					out.append(XMLMetaData.marshalModule(m, false));

					if (i.getDocuments().size() > 0) {
						for (DocumentMetaData d : i.getDocuments()) {
							out.append("\n\n");
							out.append(XMLMetaData.marshalDocument(d, false));
						}
					}
				}
				// escape html
				bean.setDocumentPreview(out.toString().replace("<", "&lt;").replace(">", "&gt;"));
			} else {
				throw new ValidationException(new Message(DocumentCreator.defaultModulePropertyName,
						"No module was specified in the script, a default module is required."));
			}

			if (i.getErrors().size() > 0) {
				StringBuilder out = new StringBuilder();
				for (SkyveScriptException e : i.getErrors()) {
					out.append(String.format("%9s: %s (line %d)", e.getType(), e.getMessage(), e.getLineNumber())).append("<br>");
				}
				bean.setErrors(out.toString());
			}
		}
		
		return new ServerSideActionResult<>(bean);
	}

}
