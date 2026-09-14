param([string]$ip = "192.168.1.3", [int]$startPort = 33000, [int]$endPort = 46000)

$ipAddr = [System.Net.IPAddress]::Parse($ip)
$batchSize = 200

for ($i = $startPort; $i -le $endPort; $i += $batchSize) {
    $currentEnd = [Math]::Min($i + $batchSize - 1, $endPort)
    $tasks = @()
    for ($p = $i; $p -le $currentEnd; $p++) {
        $sock = New-Object System.Net.Sockets.Socket([System.Net.Sockets.AddressFamily]::InterNetwork, [System.Net.Sockets.SocketType]::Stream, [System.Net.Sockets.ProtocolType]::Tcp)
        $iar = $sock.BeginConnect($ipAddr, $p, $null, $null)
        $tasks += [PSCustomObject]@{ Port = $p; Socket = $sock; Iar = $iar }
    }
    Start-Sleep -Milliseconds 150
    foreach ($t in $tasks) {
        if ($t.Iar.IsCompleted) {
            try {
                $t.Socket.EndConnect($t.Iar)
                Write-Host "FOUND OPEN PORT: $($t.Port)" -ForegroundColor Green
            } catch {}
        }
        $t.Socket.Close()
    }
}
