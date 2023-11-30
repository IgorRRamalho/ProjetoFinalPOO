package Modelo;

public class GradeCursoM {
    private int cursoId;
    private int materiaId;

    public GradeCursoM(int cursoId, int materiaId) {
        this.cursoId = cursoId;
        this.materiaId = materiaId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }
    

}

