import com.educrea.security.Role
import com.educrea.security.User
import com.educrea.security.UserRole

class BootStrap {

    def init = { 
      //servletContext ->
      def adminRole = new Role('ROLE_ADMIN').save()
      def userRole = new Role('ROLE_USER').save()

      def gmezaUser = new User('gmeza', 'password').save()

      UserRole.create gmezaUser, adminRole

      UserRole.withSession {
         it.flush()
         it.clear()
      }

      assert User.count() == 1
      assert Role.count() == 2
      assert UserRole.count() == 1
    }
    def destroy = {
    }
}
