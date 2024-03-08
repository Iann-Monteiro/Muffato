package Models;

import Enums.StatusPedido;

import java.util.Date;

public class PedidoModel {
    private int idPedido;
    private StatusPedido status;
    private Date dataPedido;
    private double distEntrega;

    public PedidoModel(int idPedido, StatusPedido status, Date dataPedido) {
        this.idPedido = idPedido;
        this.status = status;
        this.dataPedido = dataPedido;
    }

    public PedidoModel() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

}
