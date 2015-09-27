/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.mail.EmailException;


/**
 *
 */
public abstract class DefaultMB {
    
    protected String pagina;

    public Object recuperarObjetoSessao(String nome) {
        Map<String, Object> sessao = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return sessao.get(nome);
    }
    
    
    public Object registrarObjetoSessao(String nome, Object obj){
        Map<String, Object> sessao = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return sessao.put(nome, obj);
        
    }
    
    public void removerObjetoSessao(String nome){
        try{
            Map<String, Object> sessao = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessao.remove(nome);
        }catch(Exception e){
        }        
    }

    public void registrarMensagemInfo(String topo, String mensagem) {
        System.out.println("> INFO: "+mensagem);
        FacesContext.getCurrentInstance().addMessage(topo, new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
    }

    public void registrarMensagemWarning(String topo, String mensagem) {
        System.out.println("> WARNING: "+mensagem);
        FacesContext.getCurrentInstance().addMessage(topo, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
    }

    public void registrarMensagemErro(String topo, String mensagem) {
        System.out.println("> ERRO: "+mensagem);
        FacesContext.getCurrentInstance().addMessage(topo, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção:", mensagem));
    }
    
    public void registrarMensagemInfo(String mensagem) {
        System.out.println("> INFO: "+mensagem);
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
    }

    public void registrarMensagemWarning(String mensagem) {
        System.out.println("> WARNING: "+mensagem);
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
    }

    public void registrarMensagemErro( String mensagem) {
        System.out.println("> ERRO: "+mensagem);
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção:", mensagem));
    }
    
	public String limitarString(String texto, int max){
		
		if(texto.length() > max){
			texto = texto.substring(0, max)+" ...";
		}
		
		return texto;
		
	}

    
    /**
     * busca valores dos parametros repassados atraves da url
     * 
     * @param chave
     *            nome do parametro
     * @return Object objeto representando o parametro
     */
    protected Object buscarParametroRequisicao(String chave) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(chave);
    }
    
    public boolean validarCPF(String strCpf) {    
        if (strCpf.equals("")) {    
            return false;    
        }
        
        try{
        	
        
        int d1, d2;    
        int digito1, digito2, resto;    
        int digitoCPF;    
        String nDigResult;    
    
        d1 = d2 = 0;    
        digito1 = digito2 = resto = 0;    
    
        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {    
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();    
    
            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.    
            d1 = d1 + (11 - nCount) * digitoCPF;    
    
            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.    
            d2 = d2 + (12 - nCount) * digitoCPF;    
        }    
    
        //Primeiro resto da divis�o por 11.    
        resto = (d1 % 11);    
    
        //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.    
        if (resto < 2) {    
            digito1 = 0;    
        } else {    
            digito1 = 11 - resto;    
        }    
    
        d2 += 2 * digito1;    
    
        //Segundo resto da divis�o por 11.    
        resto = (d2 % 11);    
    
        //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.    
        if (resto < 2) {    
            digito2 = 0;    
        } else {    
            digito2 = 11 - resto;    
        }    
    
        //Digito verificador do CPF que est� sendo validado.    
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());    
    
        //Concatenando o primeiro resto com o segundo.    
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);    
    
        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.    
        return nDigVerific.equals(nDigResult);    
        }catch (Exception e){
        	return false;
        }
    }    
}   
