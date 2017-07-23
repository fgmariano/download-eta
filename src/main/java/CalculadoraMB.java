import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CalculadoraMB {
	
	private final int KB = 1;
	private final int MB = 2;
	private final int GB = 3;
	
	private final int KBPS = 1;
	private final int MBPS = 2;
	
	private float tamanho;
	private float velocidade;
	private int sizeType;
	private int speedType;
	private String tempo;
	
	public float getTamanho() {
		return tamanho;
	}
	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}
	public float getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	public int getSizeType() {
		return sizeType;
	}
	public void setSizeType(int sizeType) {
		this.sizeType = sizeType;
	}
	public int getSpeedType() {
		return speedType;
	}
	public void setSpeedType(int speedType) {
		this.speedType = speedType;
	}
	
	public String calcularTempo(float secs) {
		String str;
		int hrs = (int) (secs/3600);
		secs = secs % 3600;
		int mins = (int) (secs/60);
		int sec = (int) secs % 60;
		str = String.valueOf(hrs);
		if (hrs == 1) {
			str = str + " hora, ";
		} else {
			str = str + " horas, ";
		}
		str = str + String.valueOf(mins);
		if (mins == 1) {
			str = str + " minuto e ";
		} else {
			str = str + " minutos e ";
		}
		str = str + String.valueOf(sec);
		if (sec == 1) {
			str = str + " segundo.";
		} else {
			str = str + " segundos.";
		}
		return str;
	}
	
	public void calcular() {
		float seg = convertSize() / convertSpeed();
		tempo = calcularTempo(seg);		
	}
	
	public float convertSize() {
		if(sizeType == KB) {
			return tamanho;
		} else if(sizeType == MB) {
			return tamanho * 1024;
		} else if(sizeType == GB) {
			return (tamanho*1024)*1024;
		} else {
			return ((tamanho*1024)*1024)*1024;
		}
	}
	
	public float convertSpeed() {
		if(speedType == KBPS) {
			return velocidade;
		} else if(speedType == MBPS) {
			return velocidade * 1024;
		} else {
			return (velocidade*1024)*1024;
		}
	}
}
