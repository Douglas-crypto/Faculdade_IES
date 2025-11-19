#!/bin/bash

echo "--- INICIANDO SERVIÇO DE BACKUP ---"

# 1. Pede a origem
read -p "Arraste a pasta de ORIGEM: " origem

# Limpeza de aspas 
origem=${origem//\'/}
origem=${origem//\"/}

# 2. Pede o destino
read -p "Arraste a pasta de DESTINO: " destino

# Limpeza de aspas
destino=${destino//\'/}
destino=${destino//\"/}

# 3. Verificações
if [ ! -d "$origem" ]; then
    echo "ERRO: A pasta de origem não foi encontrada:"
    echo "$origem"
    exit 1
fi

# Cria o destino se não existir
if [ ! -d "$destino" ]; then
    echo "Criando pasta de destino..."
    mkdir -p "$destino"
fi

echo "Iniciando a cópia... Aguarde."

# 4. COMANDO DE BACKUP 
# cp = copiar
# -r = recursivo (pastas e subpastas)
# -u = update (só copia se o arquivo for novo ou mais recente que o destino)
# -v = verbose (mostra o que está fazendo)
cp -ruv "$origem/"* "$destino/"

if [ $? -eq 0 ]; then
    echo "--- BACKUP REALIZADO COM SUCESSO! ---"
    echo "Backup realizado em: $(date)" >> "$destino/log_backup.txt"
else
    echo "--- FALHA NO BACKUP ---"
fi