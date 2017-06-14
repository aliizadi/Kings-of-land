package singlePlayer;

public interface BuildingHouse {
	public void changeHealth(int enemyORown, int damagePoint);
	public boolean isAlive();
	public void destroy(boolean hp);
}
