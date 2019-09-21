package needscroll.BeerGrabber.Tasks;

import org.powerbot.script.rt4.ClientContext;

import needscroll.BeerGrabber.Task;

public class LoginHandler extends Task{

	public LoginHandler(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return !ctx.game.loggedIn();
	}

	@Override
	public void execute() {
		//log in
		
	}

}
