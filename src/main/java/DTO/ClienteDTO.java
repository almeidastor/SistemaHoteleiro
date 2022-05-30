
package DTO;

import java.util.Date;


public class ClienteDTO {
    private String id_Client;
    private Date dt_checkin;
    private Date dt_checkout;
    private String responsavel;
    private String id_grupo;
    private String telefone;
    private String email;
    private String categoria;
    private String orientador;
    private String n_pessoas;
    private String n_quartos;
    private String pnormal;
    private String pvegetariano;
    private String pdiversos;
    private String pinternos;
    private String observacoes;
    private String valor;
    private boolean ckbvista;
    private boolean ckbtransferencia;
    private boolean ckbcheque;
    private boolean ckbcredito;
    private boolean ckb50;            

    /**
     * @return the id_Client
     */
    public String getId_Client() {
        return id_Client;
    }

    /**
     * @param id_Client the id_Client to set
     */
    public void setId_Client(String id_Client) {
        this.id_Client = id_Client;
    }

    /**
     * @return the dt_checkin
     */
    public Date getDt_checkin() {
        return dt_checkin;
    }

    /**
     * @param dt_checkin the dt_checkin to set
     */
    public void setDt_checkin(Date dt_checkin) {
        this.dt_checkin = dt_checkin;
    }

    /**
     * @return the dt_checkout
     */
    public Date getDt_checkout() {
        return dt_checkout;
    }

    /**
     * @param dt_checkout the dt_checkout to set
     */
    public void setDt_checkout(Date dt_checkout) {
        this.dt_checkout = dt_checkout;
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the id_grupo
     */
    public String getId_grupo() {
        return id_grupo;
    }

    /**
     * @param id_grupo the id_grupo to set
     */
    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the orientador
     */
    public String getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    /**
     * @return the n_pessoas
     */
    public String getN_pessoas() {
        return n_pessoas;
    }

    /**
     * @param n_pessoas the n_pessoas to set
     */
    public void setN_pessoas(String n_pessoas) {
        this.n_pessoas = n_pessoas;
    }

    /**
     * @return the n_quartos
     */
    public String getN_quartos() {
        return n_quartos;
    }

    /**
     * @param n_quartos the n_quartos to set
     */
    public void setN_quartos(String n_quartos) {
        this.n_quartos = n_quartos;
    }

    /**
     * @return the pnormal
     */
    public String getPnormal() {
        return pnormal;
    }

    /**
     * @param pnormal the pnormal to set
     */
    public void setPnormal(String pnormal) {
        this.pnormal = pnormal;
    }

    /**
     * @return the pvegetariano
     */
    public String getPvegetariano() {
        return pvegetariano;
    }

    /**
     * @param pvegetariano the pvegetariano to set
     */
    public void setPvegetariano(String pvegetariano) {
        this.pvegetariano = pvegetariano;
    }

    /**
     * @return the pdiversos
     */
    public String getPdiversos() {
        return pdiversos;
    }

    /**
     * @param pdiversos the pdiversos to set
     */
    public void setPdiversos(String pdiversos) {
        this.pdiversos = pdiversos;
    }

    /**
     * @return the pinternos
     */
    public String getPinternos() {
        return pinternos;
    }

    /**
     * @param pinternos the pinternos to set
     */
    public void setPinternos(String pinternos) {
        this.pinternos = pinternos;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the ckbvista
     */
    public boolean isCkbvista() {
        return ckbvista;
    }

    /**
     * @param ckbvista the ckbvista to set
     */
    public void setCkbvista(boolean ckbvista) {
        this.ckbvista = ckbvista;
    }

    /**
     * @return the ckbtransferencia
     */
    public boolean isCkbtransferencia() {
        return ckbtransferencia;
    }

    /**
     * @param ckbtransferencia the ckbtransferencia to set
     */
    public void setCkbtransferencia(boolean ckbtransferencia) {
        this.ckbtransferencia = ckbtransferencia;
    }

    /**
     * @return the ckbcheque
     */
    public boolean isCkbcheque() {
        return ckbcheque;
    }

    /**
     * @param ckbcheque the ckbcheque to set
     */
    public void setCkbcheque(boolean ckbcheque) {
        this.ckbcheque = ckbcheque;
    }

    /**
     * @return the ckbcredito
     */
    public boolean isCkbcredito() {
        return ckbcredito;
    }

    /**
     * @param ckbcredito the ckbcredito to set
     */
    public void setCkbcredito(boolean ckbcredito) {
        this.ckbcredito = ckbcredito;
    }

    /**
     * @return the ckb50
     */
    public boolean isCkb50() {
        return ckb50;
    }

    /**
     * @param ckb50 the ckb50 to set
     */
    public void setCkb50(boolean ckb50) {
        this.ckb50 = ckb50;
    }

    public void setdt_checkin(Date dt_checkin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setdt_checkout(Date dt_checkout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setresponsavel(String responsavel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
