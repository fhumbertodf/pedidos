package com.educandoweb.course.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.educandoweb.course.domain.enumeration.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Cliente.
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;
	
	@Email
    @Size(min = 5, max = 254)
    @Column(name = "email", length = 254, unique = true)
    private String email;

    @Column(name = "cpf_ou_cnpj")
    private String cpfOuCnpj;

    @Column(name = "tipo_cliente")
    private Integer tipoCliente;

    @OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL)
    private Set<Endereco> enderecos = new HashSet<>();

    @ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos = new HashSet<>();
    
    @JsonIgnore
	@OneToOne
	@JoinColumn(name="user_id")
	@MapsId  
    private Usuario user;
    
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Cliente nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public Cliente email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public Cliente cpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
        return this;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(tipoCliente);
    }

    public Cliente tipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
        return this;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public Cliente addEnderecos(Endereco endereco) {
        this.enderecos.add(endereco);
        endereco.setCliente(this);
        return this;
    }

    public Cliente removeEnderecos(Endereco endereco) {
        this.enderecos.remove(endereco);
        endereco.setCliente(null);
        return this;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public Cliente addTelefones(String telefone) {
        this.telefones.add(telefone);
        return this;
    }

    public Cliente removeTelefones(String telefone) {
        this.telefones.remove(telefone);
        return this;
    }

    public void setTelefones(Set<String> strings) {
        this.telefones = strings;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public Cliente addPedidos(Pedido pedido) {
        this.pedidos.add(pedido);
        pedido.setCliente(this);
        return this;
    }

    public Cliente removePedidos(Pedido pedido) {
        this.pedidos.remove(pedido);
        pedido.setCliente(null);
        return this;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove    

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        return id != null && id.equals(((Cliente) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Cliente{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", cpfOuCnpj='" + getCpfOuCnpj() + "'" +
            ", tipoCliente='" + getTipoCliente() + "'" +
            "}";
    }
}
