# Caminhos locais (ajuste conforme sua pasta)
$env:JAVA_HOME = "C:\Users\c125762\tools\Java\jdk-21.0.9"
$env:MAVEN_HOME = "C:\Users\c125762\tools\apache-maven-3.9.11"
$env:PATH = "$env:JAVA_HOME\bin;$env:MAVEN_HOME\bin;$env:PATH"

Write-Host "Configuração aplicada:"
Write-Host "JAVA_HOME = $env:JAVA_HOME"
Write-Host "MAVEN_HOME = $env:MAVEN_HOME"

# Valida versões
Write-Host "`nVerificando versões..."
java -version
javac -version
mvn -v

# Compila projeto Maven (opcional)
Write-Host "`nCompilando projeto Maven..."
mvn clean install