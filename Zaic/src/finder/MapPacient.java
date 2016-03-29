package finder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JOptionPane;

public class MapPacient {

	public static List<DataPacienta> data = new ArrayList<DataPacienta>();
	public static Map<PacientClass,List<DataPacienta>>	mapa = new LinkedHashMap<PacientClass,List<DataPacienta>>();
	private static boolean boo;

	
	@SuppressWarnings("unchecked")
	public MapPacient() {
		try{
			mapa = (Map<PacientClass, List<DataPacienta>>) FromFile("mapas");
		}catch(Exception e){
			System.out.println("Mapas not exists");
			mapa = new LinkedHashMap<PacientClass,List<DataPacienta>>();
			data = new ArrayList<DataPacienta>();
			data.add(new DataPacienta(new PacDate(0, 0, 0), " ", 0));
			mapa.put(new PacientClass("Null", "Pointer", "Exeption", 4),data );
			save(mapa, "mapas");
		}
	}
	
	public static void newPacient(PacientClass pac, DataPacienta dataPacienta){
		
		try{
		if(mapa.containsKey(pac)){

			mapa.get(pac).add(dataPacienta);
			JOptionPane.showMessageDialog(null, "Дані оновлено!");
		}else{
			data = new ArrayList<DataPacienta>();
			data.add(dataPacienta);
				mapa.put(pac, data);
				JOptionPane.showMessageDialog(null, "Пацієнт доданий!");
		}
		}catch(NullPointerException e){
			System.out.println("Create map");
			mapa = new LinkedHashMap<PacientClass,List<DataPacienta>>();
			mapa.put(pac, data);
		}
		save(mapa,"mapas");
	}
	
	public static boolean equalsHour(PacDate pacdate, double hour) {

		try{
		Set<Entry<PacientClass, List<DataPacienta>>> entry = mapa.entrySet();
		
		for (Entry<PacientClass, List<DataPacienta>> e : entry) {
			for(int i=0;i<e.getValue().size();i++){
				if(e.getValue().get(i).getPacDate().equals(pacdate)){
					boo= e.getValue().get(i).getHour()==hour;
					if(boo==true){
						return boo;
					}
				}
			}
		}}catch(NullPointerException ex){
			return false;
			}
		return boo;
	}
	
	public static void save(Object obj,String FileName){
		try {
			FileOutputStream FileOut = new FileOutputStream(FileName + ".baj");
			ObjectOutputStream listOut = new ObjectOutputStream(FileOut);
			listOut.writeObject(obj);
			FileOut.close();
			listOut.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object FromFile(String fileName) {
		Object retObj = null;
		
		try {
			FileInputStream  fis = new FileInputStream(fileName+".baj");
			ObjectInputStream in = new ObjectInputStream(fis);
			retObj = in.readObject();
			fis.close();
			in.close();
		} catch (ClassNotFoundException e) {
				System.out.println("Class Not Found");
		} catch (FileNotFoundException e) {
			System.out.println(fileName+"File Not FOund");
		} catch (IOException e) {
				System.out.println("Some Fuck");
		}
		return retObj;
	}
}
