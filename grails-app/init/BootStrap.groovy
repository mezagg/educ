
import com.educrea.security.Role
import com.educrea.domain.Curso
import com.educrea.domain.Modulo
import com.educrea.security.User
import com.educrea.security.UserRole

class BootStrap {

    def init = { 
      //servletContext ->
      def suRole = new Role('ROLE_SU').save()
      
      def adminRole = new Role('ROLE_ADMIN').save()
      def userRole = new Role('ROLE_USER').save()

      def admin = new User('admin', 'admin').save()
      
      def instructor = new User('instructor', 'instructor').save()
      def alumno = new User('alumno', 'alumno').save()

      UserRole.create admin, adminRole
      UserRole.create admin, suRole
      UserRole.create instructor, adminRole
      UserRole.create alumno, userRole
        
        
      def curso = new Curso('SCRUM', 'Metodologias Agiles').save()
      //def modulo = new Modulo('AA', curso).save()
      
      //curso.flush()
      
      UserRole.withSession {
         it.flush()
         it.clear()
      }

      assert User.count() == 3
      assert Role.count() == 3
      assert UserRole.count() == 4
    }
    def destroy = {
    }
}
