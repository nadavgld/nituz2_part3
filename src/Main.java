import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem ss = new StudentSystem();
        String _line = null;

        while (true) {
            _line = scanner.nextLine();

            if (_line.toLowerCase().contains("exit"))
                break;

            else if (_line.toLowerCase().contains("/exam")) {
                String[] sp = _line.split(" ");
                int score = Integer.parseInt(sp[1]);

                ss.getExamStates().exam(score);
            }
            else if (_line.toLowerCase().contains("/read")) {
                ss.getArticleStates().readArticle();
            }
            else if (_line.toLowerCase().contains("/post")) {
                String[] sp = _line.split(" ");

                ss.getPostStates().post(sp[1]);
            }
//            else if (_line.toLowerCase().contains("/answer")) {
////                ss.getCurrentState().answerQuiz();
////            }
            else if (_line.toLowerCase().contains("/next_week")) {
                int week = ss.get_week();
                ss.set_week(week+1);
            }
            else if (_line.toLowerCase().contains("/status")) {
                String[] sp = _line.split(" ");
                String input = sp[1];

                input = ss.getArticleStates().status(input);
                input = ss.getPostStates().status(input);
                input = ss.getExamStates().status(input);

                System.out.println(input);
            }

        }
    }

}

