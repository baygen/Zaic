package finder;

import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class JListDataPacient implements  ListModel<DataPacienta>{

	public JListDataPacient() {
	
	}
		
	public List<DataPacienta> choosePacient(){
		PacClassToday pacTod = FrameWindow.list_Today.getSelectedValue();
		PacientClass pacient = new PacientClass(pacTod.getFamilia(), "", pacTod.getName(), pacTod.getAge());
		List<DataPacienta> ar = MapPacient.mapa.get(pacient);
		return ar;
	}
	@Override
	public void addListDataListener(ListDataListener l) {
		
	}


	@Override
	public int getSize() {
		try{
		return choosePacient().size();
		}catch(NullPointerException e){
			return 0;
		}
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		
	}
	
	@Override
	public DataPacienta getElementAt(int index) {
		return choosePacient().get(index);
	}
}
