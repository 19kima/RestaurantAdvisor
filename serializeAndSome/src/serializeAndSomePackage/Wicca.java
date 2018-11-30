package serializeAndSomePackage;

import java.io.Serializable;

public class Wicca implements Serializable {
private int what;
private String name;
private int the;
public Wicca(int what, String name, int the) {
	this.what = what;
	this.name = name;
	this.the = the;
}
public int getWhat() {
	return what;
}
public void setWhat(int what) {
	this.what = what;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getThe() {
	return the;
}
public void setThe(int the) {
	this.the = the;
}
public String toString() {
	return "name: " + name + " what: " + what + " the:" + the;
	
}

}
