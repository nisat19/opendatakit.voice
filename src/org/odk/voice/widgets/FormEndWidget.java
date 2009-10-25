package org.odk.voice.widgets;

import java.io.IOException;
import java.io.Writer;

import org.odk.voice.constants.StringConstants;
import org.odk.voice.constants.VoiceAction;
import org.odk.voice.servlet.FormVxmlServlet;
import org.odk.voice.vxml.VxmlDocument;
import org.odk.voice.vxml.VxmlForm;
import org.odk.voice.vxml.VxmlSection;
import org.odk.voice.vxml.VxmlUtils;

public class FormEndWidget extends WidgetBase {
 
  String formTitle;
  
  public FormEndWidget(String formTitle) {
    this.formTitle = formTitle;
  }
  
  @Override
  public void getPromptVxml(Writer out) throws IOException {
//    VxmlForm endForm = new VxmlForm("end", 
//        createPrompt(StringConstants.formEndPrompt(formTitle)),
//            "", "");
    VxmlSection endSection = new VxmlSection("<block>" + createPrompt(StringConstants.formEndPrompt(formTitle)).getPromptString() +
        VxmlUtils.createRemoteGoto(FormVxmlServlet.ADDR + "?action=" + VoiceAction.HANGUP) + "</block>");
    VxmlForm endForm = new VxmlForm("main", endSection);
    new VxmlDocument(endForm).write(out);
  }
}
