import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Customer {
	Stage stage;
	Scene scene;
	String email,name,contactno;
	
	Gulshan g=new Gulshan("Ant Man","12:00 pm" , "11.8.2019");
	Gulshan g1=new Gulshan("Superstar","10:00 am" , "12.8.2019");
	Gulshan g2=new Gulshan("The lion king","1:00 am" , "15.8.2019");
	Gulshan g3=new Gulshan("Spider man","2:00 pm" , "16.8.2019");
	Gulshan g4=new Gulshan("BAT MAN","12:00 pm" , "18.8.2019");
	Gulshan g5=new Gulshan("Alladin", "1:00 PM", "1.8.2019");
	Gulshan g6=new Gulshan("Wrong tune 4", "5:00 PM", "5.8.2019");
	Gulshan g7=new Gulshan("Heer maan jaa", "6:00 PM", "9.8.2019");
	Gulshan g8=new Gulshan("The Conjuring", "2:00 PM", "15.8.2019");
	Gulshan g9=new Gulshan("Annabelle Comes home", "10:00 AM", "17.8.2019");
	
	public Customer()
	{
		stage=new Stage();
		Customer1();
		stage.setScene(scene);
		stage.show();
	}
	public Customer(String name ,String cno,String email){
		stage = new Stage();
		this.name=name;
		this.email=email;
		this.contactno=cno;
		
		showmovies();
		stage.setScene(scene);
		stage.show();
	}
	private void Customer1(){
		
		Label lbl=new Label("Welcome to Cinema");
		lbl.setFont(Font.font(30));
		lbl.setTextFill(Color.RED);
		lbl.setAlignment(Pos.TOP_CENTER);
		Label ulbl=new Label("Name");
		TextField uf=new TextField();

		Label plbl=new Label("Contact number");
		TextField pf=new TextField();
		
		Label albl=new Label("Email address");
		
		TextField af=new TextField();
		
		Button login=new Button("login");
		GridPane gp=new GridPane();
		gp.add(lbl, 0, 0);
		gp.add(ulbl, 0, 1);
		gp.add(uf, 1, 1);
		gp.add(plbl, 0, 2);
		gp.add(pf, 1, 2);
		gp.add(albl, 0, 3);
		gp.add(af, 1, 3);
	
		gp.add(login, 1, 5);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(30);
		gp.setHgap(10);
		Image im=new Image("images/2.jpg");
		ImageView view=new ImageView(im);
		Group root=new Group();
		root.getChildren().addAll(view,gp);
		scene=new Scene(root,900, 680);
		login.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Customer c=new  Customer(uf.getText(), pf.getText(), af.getText());
				stage.hide();
			}
		});
		
	}
	void showmovies(){
		Gulshan Gmovies[]= new Gulshan[10];
		Gmovies[0]=g;
		Gmovies[1]=g1;
		Gmovies[2]=g2;
		Gmovies[3]=g3;
		Gmovies[4]=g4;
		Gmovies[5]=g5;
		Gmovies[6]=g6;
		Gmovies[7]=g7;
		Gmovies[8]=g8;
		Gmovies[9]=g9;
	
		Label n=new Label("your name :");
		n.setTextFill(Color.WHITE);
		n.setFont(Font.font(15));
		Label gn=new Label(name);
		gn.setFont(Font.font(15));
		gn.setTextFill(Color.WHITE);
		
		Label c=new Label("Contact number ");
		c.setTextFill(Color.WHITE);
		c.setFont(Font.font(15));
		
		Label gc=new Label(contactno);
		gc.setFont(Font.font(15));
		gc.setTextFill(Color.WHITE);
		
		Label e=new Label("Email :");
		e.setFont(Font.font(15));
		e.setTextFill(Color.WHITE);
		
		Label ge=new Label(email);
		ge.setFont(Font.font(15));
		ge.setTextFill(Color.WHITE);
		
		Label sea=new Label("Your movie ");
		sea.setFont(Font.font(15));
		sea.setTextFill(Color.WHITE);
		
		Label tic=new Label("Ticket");
		tic.setFont(Font.font(15));
		tic.setTextFill(Color.WHITE);
		TextField ticfield=new TextField();
		
		
		Button done=new Button("ticket generate ");
		
		Label movies=new Label("Movie detail");
		movies.setFont(Font.font(15));
		movies.setTextFill(Color.WHITE);
		
		ComboBox<String > cb=new ComboBox<>();
	
		TableView table =new TableView<>();
		TableColumn<String , Gulshan> cname=new TableColumn<>("Movie name ");
		TableColumn<String, Gulshan> ctime=new TableColumn<>("Show time ");
		TableColumn<String, Gulshan> cdate=new TableColumn<>("Show date ");
		cname.setPrefWidth(200);
		ctime.setPrefWidth(200);
		cdate.setPrefWidth(200);
		cname.setCellValueFactory(new PropertyValueFactory<>("Moviename"));
		
		ctime.setCellValueFactory(new PropertyValueFactory<>("Showtime"));
		cdate.setCellValueFactory(new PropertyValueFactory<>("Showdate"));
		table.getColumns().add(cname);
		table.getColumns().add(ctime);
		table.getColumns().add(cdate);
	
		
		
	
		for (Gulshan show: Gmovies){
			cb.getItems().addAll(show.moviename);
			table.getItems().add(show);

		}
		
		done.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				for(Gulshan show:Gmovies){
					
				if(show.moviename.equalsIgnoreCase(cb.getValue())) {
					int k=Integer.parseInt(ticfield.getText());
					for(int i=1;i<=k;i++){
						
					Gulshan sh=new Gulshan(show.moviename, show.showtime, show.showdate, 1);
					stage.hide();
			
					}
					
				}
				}
			}
		});
		
		
		
		HBox hb=new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().addAll(n,gn);
		
		HBox hb1=new HBox();
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.TOP_CENTER);
		hb1.getChildren().addAll(c,gc);
		
		HBox hb2=new HBox();
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.TOP_CENTER);
		hb2.getChildren().addAll(e,ge);
		

		
		
		
		GridPane gp=new GridPane();
		gp.add(sea, 0, 0);
		gp.add(cb, 0, 1);
		gp.add(tic, 1, 0);
		gp.add(ticfield, 1, 1);
		gp.setVgap(10);
		gp.setHgap(10);
		HBox hb5=new HBox();
		hb5.setSpacing(10);
		hb5.setAlignment(Pos.TOP_CENTER);
		hb5.getChildren().addAll(gp,table);
		
		
		VBox vb=new VBox();
		vb.setSpacing(20);
		vb.setAlignment(Pos.TOP_CENTER);
		vb.getChildren().addAll(hb,hb1,hb2,movies,hb5,done);
		
		
		Image im=new Image("images/4.jpg");
		ImageView view =new ImageView(im);
		
		Group root=new Group();
		root.getChildren().addAll(view,vb);
		
		scene =new Scene(root, 900, 630);
	}
	
}
