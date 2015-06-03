class Boks{
	boolean[] ledige;
	int id;
	Boks(int i, int id){
		ledige=new boolean[i];
		this.id=id;
		for(int looper=0; looper<i; looper++){
			ledige[looper]=true;
		}
	}

	public String toString() {
		return id + "";
	}
	
	public void settOpptatt(int i){
		ledige[(i-1)]=false;
	}
	public void settLedig(int i){
		ledige[(i-1)]=true;
	}
	public int getId(){
		return id;
	}
	public boolean[] getMulige(){
		return ledige;
	}

}