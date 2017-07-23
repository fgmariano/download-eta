import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CalculadoraMB {
	
	private float tamanho;
	private float velocidade;
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
		float tamanhoKB = tamanho * 1024;
		float seg = tamanhoKB / velocidade;
		tempo = calcularTempo(seg);		
	}
}
