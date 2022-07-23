/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.JobSeekerService;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerDao;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerExperienceDao;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerLanguageDao;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerSchoolDao;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerSocialMediaAccountDao;
import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import SpringProjects.HRMS.entities.concretes.JobSeekerLanguage;
import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import SpringProjects.HRMS.entities.concretes.JobSeekerSocialMediaAccount;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.ErrorDataResult;
import springprojects.HRMS.core.utilities.results.ErrorResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private JobSeekerSchoolDao jobSeekerSchoolDao;
    private JobSeekerExperienceDao jobSeekerExperienceDao;
    private JobSeekerLanguageDao jobSeekerLanguageDao;
    private JobSeekerSocialMediaAccountDao jobSeekerSocialMediaAccountDao;
    
    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerSchoolDao jobSeekerSchoolDao, JobSeekerExperienceDao jobSeekerExperienceDao, 
            JobSeekerLanguageDao jobSeekerLanguageDao, JobSeekerSocialMediaAccountDao jobSeekerSocialMediaAccountDao) {
        this.jobSeekerDao = jobSeekerDao;
        this.jobSeekerSchoolDao = jobSeekerSchoolDao;
        this.jobSeekerExperienceDao = jobSeekerExperienceDao;
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
        this.jobSeekerSocialMediaAccountDao = jobSeekerSocialMediaAccountDao;
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        if(jobSeekerDao.existsJobSeekersByTckn(jobSeeker.getTckn()))
            return new ErrorResult("Aynı TCKN ile birden fazla hesap açamazsınız.");
        else if(jobSeekerDao.existsJobSeekersByEmail(jobSeeker.getEmail()))
            return new ErrorResult("Aynı Email ile birden fazla hesap açamazsınız.");
        
        jobSeekerDao.save(jobSeeker);
        return new SuccessResult("İşlem başarılı.");
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(jobSeekerDao.findAll());
    }

    @Override
    public Result addSchool(JobSeekerSchool jobSeekerSchool) {
        jobSeekerSchoolDao.save(jobSeekerSchool);
        return new SuccessResult("Okul kaydı eklendi.");
    }

    @Override
    public Result addSchools(List<JobSeekerSchool> jobSeekerSchools) {
        for(JobSeekerSchool jobSeekerSchool: jobSeekerSchools) {
            jobSeekerSchoolDao.save(jobSeekerSchool);
        }
        return new SuccessResult("Okul kayıtları eklendi.");
    }  

    //sadece okul geçmişi için bütün job seeker datasını çektik. hiç hoş değil.
    @Override
    public DataResult<List<JobSeekerSchool>> getSchoolHistory(long jobSeekerId) {
        Optional<JobSeeker> jobSeeker = this.jobSeekerDao.getById(jobSeekerId);
        if(jobSeeker.isEmpty())
            return new ErrorDataResult<>("Geçersiz job seeker id'si");
        
        return new SuccessDataResult<>(jobSeeker.get().getSchoolHistory());
    }

    
    //burada tüm jobseeker datasını çekmedim. 2 farklı dao'dan faydalandım.
    @Override
    public DataResult<List<JobSeekerSchool>> getOrderedSchoolHistory(long jobSeekerId) {
        if(!this.jobSeekerDao.existsById(jobSeekerId))
            return new ErrorDataResult<>("Geçersiz job seeker id'si");
        
        List<JobSeekerSchool> history = this.jobSeekerSchoolDao.getByJobSeeker_Id(jobSeekerId);
        
        //Sıralama, filtereleme gibi işlemlerin DB'de halledilmesi özellikle veri boyutu fazlaysa daha verimli. Bunları dao'da halledeceğim.
        Predicate<JobSeekerSchool> graduatedSchoolsPred = item -> item.isGraduated();
        Predicate<JobSeekerSchool> nonGraduatedSchoolsPred = item -> !item.isGraduated();

        List<JobSeekerSchool> graduatedSchools = history.stream()
          .filter(graduatedSchoolsPred)
          .sorted(Comparator.comparing(JobSeekerSchool::getGraduateDate).reversed())
          .collect(Collectors.toList());
        
        List<JobSeekerSchool> nonGraduatedSchools = history.stream()
          .filter(nonGraduatedSchoolsPred)
          .sorted(Comparator.comparing(JobSeekerSchool::getStartDate).reversed())
          .collect(Collectors.toList());
                
        return new SuccessDataResult<>(Stream.concat(nonGraduatedSchools.stream(), graduatedSchools.stream())
                             .collect(Collectors.toList()));
    }
    
    @Override
    public Result addExperience(List<JobSeekerExperience> jobSeekerExperience) {
        for(JobSeekerExperience experience: jobSeekerExperience) {
            this.jobSeekerExperienceDao.save(experience);
        }
        return new SuccessResult("Deneyimler eklendi.");
    }
    
    
    @Override
    public DataResult<List<JobSeekerExperience>> getAllExperiencesByJobSeekerId(Long id) {
        Optional<JobSeeker> jobSeekerOpt = this.jobSeekerDao.getById(id);
        if(jobSeekerOpt.isEmpty())
            return new ErrorDataResult<>("Geçersiz job seeker id'si");
        
        return new SuccessDataResult<>(jobSeekerOpt.get().getExperiences());
    }

    /*
    Yukarıdaki tüm jobseeker bilgilerini çekip onun üstünden deneyimlere erişiyor. Sıralama yapılması gerekseydi programatik olarak yapılması lazımdı. Kötü bir yaklaşım.
    Bu metotta oldugu gibi bu işleri dao'ya bırakmak gerek.
    */
    @Override
    public DataResult<List<JobSeekerExperience>> getByJobSeeker_IdOrderByStartDateDesc(long jobSeekerId) {
        if(!this.jobSeekerDao.existsById(jobSeekerId))
            return new ErrorDataResult<>("Geçersiz job seeker id'si");
        
        return new SuccessDataResult<>(this.jobSeekerExperienceDao.getByJobSeeker_IdOrderByStartDateDesc(jobSeekerId));
    }

    @Override
    public Result addJobSeekerLanguage(JobSeekerLanguage jobSeekerLanguage) {
        this.jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult("Dil eklendi.");
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguagesByJobSeekerId(long jobSeekerId) {
        return new SuccessDataResult<>(this.jobSeekerLanguageDao.getByJobSeeker_Id(jobSeekerId));
    }

    @Override
    public Result addSocialMediaAccount(JobSeekerSocialMediaAccount account) {
        this.jobSeekerSocialMediaAccountDao.save(account);
        return new SuccessResult("Sosyal medya hesabı eklendi.");
    }

    @Override
    public DataResult<List<JobSeekerSocialMediaAccount>> getAllSocialMediaAccounts(long jobSeekerId) {
        if(!this.jobSeekerDao.existsById(jobSeekerId))
            return new ErrorDataResult<>("Geçersiz job seeker id'si");
        
        return new SuccessDataResult<>(this.jobSeekerSocialMediaAccountDao.getByJobSeeker_Id(jobSeekerId));
    }

    @Override
    public Result addPretext(String pretext) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
