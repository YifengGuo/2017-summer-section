library(plotrix)
xy.pop<-c(13,14,13,14,14,14,14,4)
xx.pop<-c(13,14,13,14,14,14,14,4)
activity<-c("Airway-Stated","Breath-Sounds","Distal-Pulses","GCS-Stated","Pupil-Exam","Temperature","Warm-Blanket","Central-Pulses")
mcol<-color.gradient(c(0,0,0.5,1),c(0,0,0.5,1),c(1,1,0.5,1),18)
fcol<-color.gradient(c(1,1,0.5,1),c(0.5,0.5,0.5,1),c(0.5,0.5,0.5,1),18)
par(mar=pyramid.plot(xy.pop,xx.pop,labels=activity,
                     main="Activity Frequency",lxcol=mcol,rxcol=fcol,
                     gap=5,show.values=TRUE))

