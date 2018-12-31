package optional;

import java.util.Optional;

public class OptionalOracleExemplo {
	public static void main(String[] args) {
		USB usb = new USB();
		usb.setVersion("3.0");
		
		Soundcard soundcard = new Soundcard();
		soundcard.setUsb(Optional.of(usb));
		
		Computer computer = new Computer();
		computer.setSoundcard(Optional.of(soundcard));
				
		String name = computer.getSoundcard()
                .flatMap(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
		System.out.println(name);
			      
	}
}

class Computer {
	private Optional<Soundcard> soundcard;

	public Optional<Soundcard> getSoundcard() {
		return soundcard;
	}

	public void setSoundcard(Optional<Soundcard> soundcard) {
		this.soundcard = soundcard;
	}

	@Override
	public String toString() {
		return "\nComputer [soundcard=" + soundcard + ", getSoundcard()=" + getSoundcard() + "]";
	}
	
}

class Soundcard {
	private Optional<USB> usb;

	public Optional<USB> getUsb() {
		return usb;
	}

	public void setUsb(Optional<USB> usb) {
		this.usb = usb;
	}

	@Override
	public String toString() {
		return "\nSoundcard [usb=" + usb + ", getUsb()=" + getUsb() + "]";
	}
}

class USB {
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "\nUSB [version=" + version + "]";
	}
}
