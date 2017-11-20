package mx.ipn.escom.socialwriters.accesoDB.utilidades;

public class ObtenHash {
	
	public ObtenHash() {
		
	}
	
	public int hash(String pass) {
        int hash = 0;
        int chr;
        if (pass.length() == 0) {
            return hash;
        } else {
            for (int i = 0; i < pass.length(); i++) {
                chr = pass.charAt(i);
                hash = ((hash << 5) - hash) + chr;
                hash = hash & hash;
            }
            return hash;
        }

    }

}
