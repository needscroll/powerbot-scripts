package needscroll.TabberGrabber.Tasks;

import org.powerbot.script.rt6.ClientContext;
import needscroll.TabberGrabber.Task;

public class FailLobby extends Task{

	public FailLobby(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		System.out.println("lobby in");
		return ctx.lobby.opened();
	}

	@Override
	public void execute() {
		System.out.println("lobby out");
		ctx.lobby.enterGame();
	}

}
