package gov.iti.jets;

import java.io.File;
import org.alicebot.ab.*;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;

public class ChatBot {
    private static final boolean TRACE_MODE = false;

    public static String getResponse(String msg) {
        try {
            String resourcesPath = getResourcesPath();
            MagicBooleans.trace_mode = TRACE_MODE;
            Bot bot = new Bot("super", resourcesPath);
            org.alicebot.ab.Chat chatSession = new org.alicebot.ab.Chat(bot);
            bot.brain.nodeStats();
            String textLine = msg;
            if ((textLine == null) || (textLine.length() < 1))
                textLine = MagicStrings.null_input;
            else {
                String request = textLine;
                if (MagicBooleans.trace_mode)
                    System.out.println("STATE=" + request + ":THAT=" + ((History)chatSession.thatHistory.get(0)).get(0)
                            + ":TOPIC=" + chatSession.predicates.get("topic"));
                String response = chatSession.multisentenceRespond(request);
                while (response.contains("&lt;"))
                    response = response.replace("&lt;", "<");
                while (response.contains("&gt;"))
                    response = response.replace("&gt;", ">");
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }
}