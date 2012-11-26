
public class Player {
	enum Status {CONNECTED, DISCONNECTED;}
	
	private String name;
	private String address;
	private Status status;
	
	public Player(String name, String address){
		this.name = name;
		this.address = address;
		this.status = Status.CONNECTED;
	}

	public boolean isConnected (){
		return (status == Status.CONNECTED)? true : false;
	}
	
	public boolean equals(Player player){
		return (this.name == player.name && this.address == player.address) ? true : false;
	}
	
	public boolean connect(){
		if (status == Status.DISCONNECTED){
			this.status = Status.CONNECTED;
			return true;
		}
		return false;
	}
	
	public boolean disconnect(){
		if (status == Status.CONNECTED){
			this.status = Status.DISCONNECTED;
			return true;
		}
		return false;
	}
}