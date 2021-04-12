package TableModel;

import Entities.Music;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class MusicModel
  extends AbstractTableModel
{
  private final String[] colunas = { "Name", "Autor", "Album" };
  

  private ArrayList<Music> linhas;
  


  public MusicModel()
  {
    linhas = new ArrayList();
  }
  
  public MusicModel(ArrayList<Music> linhas) {
    this.linhas = linhas;
  }
  

  public int getRowCount()
  {
    return linhas.size();
  }
  
  public int getColumnCount()
  {
    return colunas.length;
  }
  
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Music m = (Music)linhas.get(rowIndex);
    switch (columnIndex) {
    case 0: 
      return m.getName();
    case 1: 
      return m.getAutor();
    case 2: 
      return m.getAlbum();
    }
    
    
    return null;
  }
  

  public void setValueAt(Object objetct, int rowIndex, int columnIndex)
  {
    Music m = (Music)linhas.get(rowIndex);
    String value = (String)objetct;
    switch (columnIndex) {
    case 0: 
      m.setName(value);
      break;
    case 1: 
      m.setAutor(value);
      break;
    case 2: 
      m.setAlbum(value);
      break;
    }
    
    

    fireTableRowsInserted(rowIndex, rowIndex);
  }
  
//  JButton snapshot = new JButton("");
//		snapshot.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				BufferedImage img = emp.getSnapshot();
//				String path = System.getProperty("user.home")+"\\Pictures\\";
//				String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
//				File imgSnap = new File(path+fileName+".png");
//				System.out.println(imgSnap.getAbsolutePath());
//				try {
//					ImageIO.write(img, "png", imgSnap);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//		snapshot.setIcon(new ImageIcon(TableModel.class.getResource("/application/Icons/Graphite/snapshot.png")));
//		snapshot.setToolTipText("Take Snapshot");
//		snapshot.setOpaque(false);
//		snapshot.setFocusable(false);
//		snapshot.setContentAreaFilled(false);
//		snapshot.setBorderPainted(false);
//		panel.add(snapshot);
//		
//}

  public String getColumnName(int column)
  {
    return colunas[column];
  }
  

  public Class<?> getColumnClass(int columnIndex)
  {
    switch (columnIndex) {
    case 0: 
      return String.class;
    case 1: 
      return String.class;
    case 2: 
      return String.class;
    }
    
    return null;
  }
  

  public void limpar()
  {
    linhas.clear();
    

    fireTableDataChanged();
  }
  
  public void addListaDeMusicas(List<Music> musicas)
  {
    int indice = getRowCount();
    

    linhas.addAll(musicas);
    

    fireTableRowsInserted(indice, indice + musicas.size());
  }
  
  public Music getMusica(int rowIndex)
  {
    return (Music)linhas.get(rowIndex);
  }
  
  public void addMusica(Music musica)
  {
    linhas.add(musica);
    



    int ultimoIndice = getRowCount() - 1;
    

    fireTableRowsInserted(ultimoIndice, ultimoIndice);
  }
  

  public void removeMusica(int indiceLinha)
  {
    linhas.remove(indiceLinha);
    

    fireTableRowsDeleted(indiceLinha, indiceLinha);
  }
  
  public ArrayList<Music> getAsArrayList() {
    return linhas;
  }
  
  public void mistura() {
    Collections.shuffle(linhas);
    


    fireTableRowsUpdated(0, linhas.size() - 1);
  }
}
