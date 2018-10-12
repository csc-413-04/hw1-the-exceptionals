package simpleserver;

import com.google.gson.annotations.Expose;

public class Response {
	iData[] data;
	public String status;
	public int entries;



	void doStuff(iData datatype) {

	}

	public void setStatus(String status){
		this.status = status;
	}

	public void setData(iData[] data) {
			this.entries = data.length;
			this.data = data;
	}
}
