package finder;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class JListM implements ListModel<PacientClass>{
	
	static List<PacientClass> PacientList= new ArrayList<PacientClass>();  
	@SuppressWarnings("unchecked")
	public JListM() {
		try{
		PacientList = (List<PacientClass>) MapPacient.FromFile("lists");
		}catch(NullPointerException e){
			System.out.println("lists not exists");
			PacientList= new ArrayList<PacientClass>();
			PacientList.add(new PacientClass("Null Pointer","", "Exeption", 6));
			MapPacient.save(PacientList, "lists");
		}

	}
	@Override
	public void addListDataListener(ListDataListener l) {
	}

	@Override
	public PacientClass getElementAt(int index) {
		try{
		return PacientList.get(index);
		}catch(IndexOutOfBoundsException e){
			System.out.println("null index off");
			return null;
		}
	}

	@Override
	public int getSize() {
		try{
		return PacientList.size();
	}catch(NullPointerException e){
		System.out.println("size list 0");
		return 0;
	}
	}
	
	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}
	
	public void RemovePac(PacientClass pac){
		PacientList.remove(pac);
	}

}
