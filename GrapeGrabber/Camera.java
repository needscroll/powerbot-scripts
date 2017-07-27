package needscroll.GrapeGrabber;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

public class Camera extends ClientAccessor{
	
	public Camera(ClientContext ctx)
	{
		super(ctx);
	}
	
	public void fix_cam(String choice)
	{
		if (choice == "door")
		{
			fix_cam_door();
		}
		if (choice == "default")
		{
			fix_cam_default();
		}
	}
	
	private void fix_cam_door()
	{
		ctx.camera.angle('s');
		Condition.sleep(1000);

		ctx.camera.pitch(47);
		Condition.sleep(1000);
	}
	
	private void fix_cam_default()
	{
		ctx.camera.angle('n');
		Condition.sleep(1000);

		ctx.camera.pitch(77);
		Condition.sleep(1000);
	}
}