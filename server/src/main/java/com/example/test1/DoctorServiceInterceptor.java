package com.example.test1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.test1.model.DocumentReport;
import com.example.test1.repository.DocumentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class DoctorServiceInterceptor implements HandlerInterceptor {
    @Autowired
    private DocumentReportRepository documentReportRepository;

    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("Pre Handle method is Calling");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("Post Handle method is Calling");
    }
    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {
        List<DocumentReport> documentReports = documentReportRepository.findAll();

        if (documentReports.size() > 0) {
            DocumentReport lastDocumentReport = documentReports.get(documentReports.size() - 1);
            Integer status = response.getStatus();
            lastDocumentReport.setError(status.toString());

            documentReportRepository.save(lastDocumentReport);
        }
    }
}
