#Jackson-databind jar utomatically converts object<->json using Message Converter.It comes with spring boot starter web dependency.
#Add jackson-dataformat-xml jar explicitly in pom allows xml format.

#spring-boot-starter-jpa needs a database dependency in pom.Default is embedded.
#Spring security jar generates default password.
#Prior to Spring Security 5.0 the default PasswordEncoder was NoOpPasswordEncoder which required plain text passwords. In Spring Security 5, the default is DelegatingPasswordEncoder, which required Password Storage Format.
#{noop}. Else : java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
