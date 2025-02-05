import com.casino.controller.BlackjackController;
import com.casino.model.Blackjack;
import com.casino.view.BlackjackView;

public class BlackjackMain {
    public static void main(String[] args) {
        Blackjack model = new Blackjack();
        BlackjackView view = new BlackjackView(model);
        new BlackjackController(model, view);
    }
}
