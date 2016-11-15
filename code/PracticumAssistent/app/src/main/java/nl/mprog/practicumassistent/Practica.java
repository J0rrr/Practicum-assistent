package nl.mprog.practicumassistent;

public class Practica {

    private int _id;
    private String _practicumnaam;
    private String _practicumdatum;
    private String _practicumopmerking;

    public Practica(String naam, String datum, String opmerking){
        this._practicumnaam = naam;
        this._practicumdatum = datum;
        this._practicumopmerking = opmerking;
    }


    // Setters

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_practicumnaam(String _practicumnaam) {
        this._practicumnaam = _practicumnaam;
    }

    public void set_practicumdatum(String _practicumdatum) {
        this._practicumdatum = _practicumdatum;
    }

    public void set_practicumopmerking(String _practicumopmerking) {
        this._practicumopmerking = _practicumopmerking;
    }


    // Getters


    public String get_practicumnaam() {
        return _practicumnaam;
    }

    public int get_id() {
        return _id;
    }

    public String get_practicumdatum() {
        return _practicumdatum;
    }

    public String get_practicumopmerking() {
        return _practicumopmerking;
    }
}
