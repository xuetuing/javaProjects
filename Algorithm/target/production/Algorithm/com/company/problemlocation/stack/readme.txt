线程堆栈：locked, waiting to lock, waiting on

"com.company.problemlocation.stack.ThreadWaitingOn" #13 prio=5 os_prio=0 tid=0x0
00000005643b000 nid=0xdfc in Object.wait() [0x00000000577cf000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000ed966578> (a java.lang.Object)
        at com.company.problemlocation.stack.ThreadWaitingOn.func_waiting(Thread
WaitingOn.java:22)
        at com.company.problemlocation.stack.ThreadWaitingOn.func(ThreadWaitingO
n.java:16)
        - locked <0x00000000ed966578> (a java.lang.Object)
        at com.company.problemlocation.stack.ThreadWaitingOn.run(ThreadWaitingOn
.java:11)

"com.company.problemlocation.stack.ThreadWaitingTo" #12 prio=5 os_prio=0 tid=0x0
00000005643a000 nid=0x13cc waiting for monitor entry [0x000000005761e000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.company.problemlocation.stack.ThreadWaitingTo.func(ThreadWaitingT
o.java:17)
        - waiting to lock <0x00000000ed95b5e0> (a java.lang.Object)
        at com.company.problemlocation.stack.ThreadWaitingTo.run(ThreadWaitingTo
.java:12)

"com.company.problemlocation.stack.ThreadLocked" #11 prio=5 os_prio=0 tid=0x0000
000056439800 nid=0xfbc waiting on condition [0x00000000574bf000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at com.company.problemlocation.stack.ThreadLocked.func_waiting(ThreadLoc
ked.java:24)
        at com.company.problemlocation.stack.ThreadLocked.func(ThreadLocked.java
:17)
        - locked <0x00000000ed95b5e0> (a java.lang.Object)
        at com.company.problemlocation.stack.ThreadLocked.run(ThreadLocked.java:
12)
