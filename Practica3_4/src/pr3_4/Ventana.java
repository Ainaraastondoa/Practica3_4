package pr3_4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
	}
	
	public Ventana() {
		//Configuración de ventana
		setTitle( "Ventana de visualizacion" );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 800, 400 );
		setLocationRelativeTo( null );
		//Creamos los componentes
		JButton bcrear = new JButton("Crear");
		JButton bBorrar = new JButton("Borrar");
		JButton bañadir = new JButton("Añadir");
		JPanel panelinf = new JPanel();
		panelinf.add(bcrear);
		panelinf.add(bBorrar);
		panelinf.add(bañadir);
		getContentPane().add(panelinf, BorderLayout.SOUTH);
		
		//Eventos de componentes
		bcrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}	
		});
		
		bBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}	
		});
		
		bañadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//Eventos de la ventana para hacer la parte de propiedades
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				//Cuando se cierra la ventana guardamos properties
				Properties properties = new Properties();
				if(bcrear != null) {
					properties.setProperty("Crear", bcrear.toString());
				}
				
				if(bBorrar != null) {
					properties.setProperty("Borrar", bBorrar.toString());
				}
				
				if(bañadir != null) {
					properties.setProperty("Añadir", bañadir.toString());
				}
				
				try {
					properties.storeToXML(new FileOutputStream("propiedades.xml"), "propiedades del programa");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				//Cuando se abre la ventana cargamos properties
				Properties properties = new Properties();
				try {
					properties.loadFromXML(new FileInputStream("propiedades.xml"));
				} catch (InvalidPropertiesFormatException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
			
			
		});
		
	}
	
	

}
