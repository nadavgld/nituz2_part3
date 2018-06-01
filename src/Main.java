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

                ss.getCurrentState().exam(score);
            }
            else if (_line.toLowerCase().contains("/read")) {
                ss.getCurrentState().readArticle();
            }
            else if (_line.toLowerCase().contains("/post")) {
                String[] sp = _line.split(" ");

                ss.getCurrentState().post(sp[1]);
            }
            else if (_line.toLowerCase().contains("/answer")) {
                ss.getCurrentState().answerQuiz();
            }
            else if (_line.toLowerCase().contains("/next_week")) {
                ss.getCurrentState().nextWeek();
            }
            else if (_line.toLowerCase().contains("/status")) {
                String[] sp = _line.split(" ");
                String input = sp[1];

                ss.getCurrentState().status(input);
            }

        }
    }

}

