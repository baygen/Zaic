package finder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class JListTodayPacient implements ListModel<PacClassToday>{
	
	static Map<PacDate,List<PacClassToday>> todayMap = new LinkedHashMap<PacDate, List<PacClassToday>>();
	static List<PacClassToday> TodayList = new ArrayList<PacClassToday>();
	private static PacDate pacD ;
	static Date dayTo = new Date();
	static Set<Entry<PacDate, List<PacClassToday>>> entry = todayMap.entrySet();
	
	private  Comparator<PacClassToday> comparat = new Comparator<PacClassToday>() {
		@Override
		public int compare(PacClassToday o1, PacClassToday o2) {
			if(o2.getTime()<o1.getTime()){
			return -1;
			}else if(o2.getTime()>o1.getTime()){
			return 1;
			}
			return 0;
		}
				
	};
	
		@SuppressWarnings({ "unchecked" })
		public JListTodayPacient(){
			try{
				todayMap = (Map<PacDate,List<PacClassToday>>)MapPacient.FromFile("Todays");
				compareList();
			}catch(NullPointerException w){
				System.out.println("Todays not exist");
				todayMap=new LinkedHashMap<PacDate, List<PacClassToday>>();
				TodayList.add(new PacClassToday(" ", "", "", 0, 9));
				todayMap.put(dateToPac(), TodayList);
				MapPacient.save(todayMap, "Todays");
			}catch(ClassCastException c){}
		}
		
		
	public  void compareList(){
			TodayList.sort(comparat);
			
	}	

	public static void puttoTodaymap(PacDate pacdate, PacClassToday pacSeanse){
		try{
			if(todayMap.containsKey(pacdate)){
				todayMap.get(pacdate).add(pacSeanse);
			}else{
				TodayList.add(pacSeanse);
				todayMap.put(pacdate, TodayList);
			}
		}catch(NullPointerException w){
			System.out.println("Non data to save");
			todayMap = new LinkedHashMap<PacDate, List<PacClassToday>>();
			TodayList.add(pacSeanse);
			todayMap.put(pacdate, TodayList);

			}
		MapPacient.save(todayMap, "Todays");
	}
	
	@SuppressWarnings("deprecation")
	public static PacDate dateToPac(){
		int day=  dayTo.getDate();
		int month = dayTo.getMonth()+1;
		int year = dayTo.getYear()+1900;
		pacD = new PacDate(year, month, day);
		return pacD;
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		
	}

	@Override
	public PacClassToday getElementAt(int arg0) {
		try{
			compareList();
			return todayMap.get(dateToPac()).get(arg0);
			
			}catch(NullPointerException e){
				System.out.println("get element =null");
				return null;
			}catch(ClassCastException cc){
				return null;
			}catch(IndexOutOfBoundsException i){
				return null;
			}
	}

	@Override
	public int getSize() {
		try{			
			compareList();
			return todayMap.get(dateToPac()).size();
		}catch(NullPointerException e){
			System.out.println("Nons size today");
			return 1;
		}
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		
	}

	
}
