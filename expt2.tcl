set ns [new Simulator]

set nf [open expt2.nam w]
$ns namtrace-all $nf

set nd [open expt2.tr w]
$ns trace-all $nd

proc finish {} {
global ns nf nd
$ns flush-trace
close $nf
close $nd
exec nam expt2.nam &
exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]

$ns duplex-link $n1 $n0 1Mb 1ms DropTail
$ns duplex-link $n2 $n0 1Mb 1ms DropTail
$ns duplex-link $n3 $n0 1Mb 1ms DropTail
$ns duplex-link $n4 $n0 1Mb 1ms DropTail
$ns duplex-link $n5 $n0 1Mb 1ms DropTail
$ns duplex-link $n6 $n0 256Kb 200ms DropTail

Agent/Ping instproc recv {from rtt} {
$self instvar node_
puts "node [$node_ id] recieved ping answer from $from with round-trip-time $rtt ms."
}

set p1 [new Agent/Ping]
set p2 [new Agent/Ping]
set p3 [new Agent/Ping]
set p4 [new Agent/Ping]
set p5 [new Agent/Ping]
set p6 [new Agent/Ping]
set p7 [new Agent/Ping]
set p8 [new Agent/Ping]
set p9 [new Agent/Ping]

$ns attach-agent $n1 $p1
$ns attach-agent $n2 $p2
$ns attach-agent $n3 $p3
$ns attach-agent $n4 $p4
$ns attach-agent $n5 $p5
$ns attach-agent $n6 $p6
$ns attach-agent $n6 $p7
$ns attach-agent $n6 $p8
$ns attach-agent $n6 $p9


$ns queue-limit $n0 $n1 3
$ns queue-limit $n0 $n2 3
$ns queue-limit $n0 $n3 3
$ns queue-limit $n0 $n4 2
$ns queue-limit $n0 $n5 2
$ns queue-limit $n0 $n6 2



$ns connect $p1 $p6

$ns connect $p2 $p6
$ns connect $p3 $p7
$ns connect $p4 $p8



$ns at 0.1 "$p1 send"
$ns at 0.11 "$p2 send"
$ns at 0.11 "$p3 send"
$ns at 0.11 "$p4 send"

$ns at 0.2 "$p1 send"
$ns at 0.2 "$p2 send"
$ns at 0.3 "$p3 send"
$ns at 0.4 "$p4 send"

$ns at 0.6 "$p1 send"
$ns at 0.7 "$p2 send"
$ns at 0.7 "$p3 send"
$ns at 0.7 "$p4 send"

$ns at 0.10 "$p1 send"
$ns at 0.11 "$p2 send"
$ns at 0.12 "$p3 send"
$ns at 0.11 "$p4 send"

$ns at 0.13 "$p1 send"
$ns at 0.13 "$p2 send"
$ns at 0.14 "$p3 send"
$ns at 0.14 "$p4 send"

$ns at 0.15 "$p1 send"
$ns at 0.15 "$p2 send"
$ns at 0.16 "$p3 send"
$ns at 0.16 "$p4 send"





$ns at 3.0 "finish"
$ns run

