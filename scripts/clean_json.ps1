param(
    [Parameter(Mandatory=$true)][string]$InputFile,
    [Parameter(Mandatory=$false)][string]$OutputFile = "$PSScriptRoot\livros-corrigido.json"
)

if (-not (Test-Path $InputFile)) {
    Write-Error "Arquivo não encontrado: $InputFile"
    exit 1
}

$raw = Get-Content -Raw -Encoding UTF8 $InputFile

# Substitui disponivel 1/0 por true/false
$raw = $raw -replace '"disponivel"\s*:\s*1', '"disponivel": true'
$raw = $raw -replace '"disponivel"\s*:\s*0', '"disponivel": false'

# Substitui valores vazios de "valor" por 0.00
$raw = $raw -replace '"valor"\s*:\s*""', '"valor": 0.00'

# Algumas fontes usam números com vírgula — assegure ponto decimal (se necessário)
$raw = $raw -replace '"valor"\s*:\s*(\d+),(\d+)', '"valor": $1.$2'

# Grava saída
Set-Content -Encoding UTF8 -Path $OutputFile -Value $raw
Write-Output "Arquivo corrigido salvo em: $OutputFile"
