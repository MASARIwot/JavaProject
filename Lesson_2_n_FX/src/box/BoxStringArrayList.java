package box;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * this class is Boxing ArrayList<String>()
 * @author Саня
 */
public class BoxStringArrayList implements Serializable {

	private static final long serialVersionUID = 1001L;
	private ArrayList<String> strBox;
	
	public BoxStringArrayList(){
		
	}
	/**
	 * @param arrIn
	 * param ArrayList<String> arrIn
	 */
	public BoxStringArrayList(ArrayList<String> arrIn){
		this.strBox = arrIn;
	}
	/**
	 * @return strBox
	 * return ArrayList<String>
	 */
	public ArrayList<String> getStrBox() {
		return strBox;
	}
	/**
	 * @param strBox
	 * param ArrayList<String> strBox
	 */
	public void setStrBox(ArrayList<String> strBox) {
		this.strBox = strBox;
	}
	@Override
	public String toString() {
		return "BoxStringArrayList [strBox=" + strBox + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof BoxStringArrayList)){
			return false;
		}
		BoxStringArrayList other =(BoxStringArrayList)obj;
		return (this.strBox.toString()).equals(other.strBox.toString());
	}
	

}
