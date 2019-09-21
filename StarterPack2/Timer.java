package needscroll.StarterPack2;

public class Timer {
	
	long now;
	long alarm;
	//long now = System.currentTimeMillis();
	
	public Timer(long duration)
	{
		reset_timer(duration);
	}
	
	public void reset_timer(long duration)
	{
		now = System.currentTimeMillis();
		alarm = now + duration * 1000;
	}
	
	public boolean running()
	{
		now = System.currentTimeMillis();
		return alarm > now;
	}
	
	public long remaining_time()
	{
		return (alarm - now) / 1000;
	}
	

}
