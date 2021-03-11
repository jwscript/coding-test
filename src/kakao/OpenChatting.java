/**
 * 카카오 2019 - 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
 */
package kakao;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class OpenChatting {
    public String[] main(String[] record) {
        Map<String, String> idmap = new HashMap<>();

        int cnt = 0;
        for (String str : record) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();
            if (cmd.equals("Enter") || cmd.equals("Leave")) ++cnt;

            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String id = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                idmap.put(id, name);
            }
        }

        String[] answer = new String[cnt];
        int idx = 0;
        for (String str : record) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();
            if (cmd.equals("Enter")) {
                String id = tokenizer.nextToken();
                answer[idx++] = idmap.get(id) + "님이 들어왔습니다.";
            } else if (cmd.equals("Leave")) {
                String id = tokenizer.nextToken();
                answer[idx++] = idmap.get(id) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}