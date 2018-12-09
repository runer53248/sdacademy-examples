package pl.sdacademy.gracz;

public interface Player<M extends Monster> {
  public void attack(M enemy);
  
}
