package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class Encode_Filter
 */
public class Encode_Filter implements Filter {

	//�ַ������ʼ������
	protected String encoding = null;
	
	//FilterConfig����
	protected FilterConfig filterfConfig = null;
	
    /**
     * Default constructor. 
     */
    public Encode_Filter() {
        // TODO Auto-generated constructor stub
    }

	/**���ٷ���
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.encoding = null;
		this.filterfConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//�ж��ַ������Ƿ���Ч
		if(encoding != null) {
			//����request�ַ�����
			request.setCharacterEncoding("utf-8");
			//����response�ַ�����
			response.setContentType("text/html ; charset="+encoding);
		}
		
		//������һ��������
		chain.doFilter(request, response);
	}

	/**��ʼ������
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterfConfig) throws ServletException {
		// TODO Auto-generated method stub
		//��FilterConfig��ֵ
		this.filterfConfig = filterfConfig;
		//�Գ�ʼ��������ֵ
		this.encoding = filterfConfig.getInitParameter("encoding");
	}

}
