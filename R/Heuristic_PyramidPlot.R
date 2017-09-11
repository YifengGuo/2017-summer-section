my_function <- function (lx, rx, labels = NA, top.labels = c("Origin", "", 
                                                             "Semi-Synthetic"), main = "", laxlab = NULL, raxlab = NULL, unit = "occurrence per 100 cases", 
                         lxcol, rxcol, gap = 1, space = 0.2, ppmar = c(4, 2, 4, 2), 
                         labelcex = 0.7, add = FALSE, xlim, show.values = FALSE, ndig = 1, 
                         do.first = NULL)  # labelcex is the font size of labels, space is the interval of each bar
{
  if (any(c(lx, rx) < 0, na.rm = TRUE)) 
    stop("Negative quantities not allowed")
  lxdim <- dim(lx)
  rxdim <- dim(rx)
  ncats <- ifelse(!is.null(lxdim), dim(lx)[1], length(lx))
  if (length(labels) == 1) 
    labels <- 1:ncats
  ldim <- length(dim(labels))
  nlabels <- ifelse(ldim, length(labels[, 1]), length(labels))
  if (nlabels != ncats) 
    stop("lx and labels must all be the same length")
  if (missing(xlim)) 
    xlim <- rep(ifelse(!is.null(lxdim), ceiling(max(c(rowSums(lx), 
                                                      rowSums(rx)), na.rm = TRUE)), ceiling(max(c(lx, rx), 
                                                                                                na.rm = TRUE))), 2)
  if (!is.null(laxlab) && xlim[1] < max(laxlab)) 
    xlim[1] <- max(laxlab + 60)  # modify x-axis label scaling
  if (!is.null(raxlab) && xlim[2] < max(raxlab)) 
    xlim[2] <- max(raxlab + 60)  # modify x-axis label scaling
  oldmar <- par("mar")
  if (!add) {
    par(mar = ppmar, cex.axis = labelcex)
    plot(0, xlim = c(-(xlim[1] + gap), xlim[2] + gap), ylim = c(0, 
                                                                ncats + 1), type = "n", axes = FALSE, xlab = "", 
         ylab = "", xaxs = "i", yaxs = "i", main = main)
    if (!is.null(do.first)) 
      eval(parse(text = do.first))
    if (is.null(laxlab)) {
      laxlab <- seq(xlim[1] - gap, 0, by = -1)
      axis(1, at = -xlim[1]:-gap, labels = laxlab)
    }
    else axis(1, at = -(laxlab + gap), labels = laxlab)
    if (is.null(raxlab)) {
      raxlab <- 0:(xlim[2] - gap)
      axis(1, at = gap:xlim[2], labels = raxlab)
    }
    else axis(1, at = raxlab + gap, labels = raxlab)
    if (gap > 0) {
      if (!is.null(lxdim)) 
        axis(2, at = 1:ncats, labels = rep("", ncats), 
             pos = gap, tcl = -0.25)
      else axis(2, at = 1:ncats * as.logical(rx + 1), labels = rep("", 
                                                                   ncats), pos = gap, tcl = -0.25)
      if (!is.null(lxdim)) 
        axis(4, at = 1:ncats, labels = rep("", ncats), 
             pos = -gap, tcl = -0.25)
      else axis(4, at = 1:ncats * as.logical(lx + 1), labels = rep("", 
                                                                   ncats), pos = -gap, tcl = -0.25)
    }
    if (is.null(dim(labels))) {
      if (gap) 
        text(0, 1:ncats, labels, cex = labelcex)
      else {
        text(xlim[1], 1:ncats, labels, cex = labelcex, 
             adj = 0)
        text(xlim[2], 1:ncats, labels, cex = labelcex, 
             adj = 1)
      }
    }
    else {
      if (gap) {
        lpos <- -gap
        rpos <- gap
      }
      else {
        lpos <- -xlim[1]
        rpos <- xlim[2]
      }
      text(lpos, 1:ncats, labels[, 1], pos = 4, cex = labelcex, 
           adj = 0)
      text(rpos, 1:ncats, labels[, 2], pos = 2, cex = labelcex, 
           adj = 1)
    }
    mtext(top.labels, 3, 0, at = c(-xlim[1]/1.4, 0, xlim[2]/1.4), 
          adj = 0.5, cex = labelcex + 0.2) # modify top.label font size
    mtext(c(unit, unit), 1, 2, at = c(-xlim[1]/1.3, xlim[2]/1.3))  # modify unit position 
  }
  halfwidth <- 0.5 - space/2
  if (is.null(lxdim)) {
    if (missing(lxcol)) 
      lxcol <- rainbow(ncats)
    if (missing(rxcol)) 
      rxcol <- rainbow(ncats)
    lxcol <- ifelse(lx >= rx, "green", "red") # modify bar color
    rxcol <- ifelse(rx >= lx, "green", "red") # modify bar color
    rect(-(lx + gap), 1:ncats - halfwidth, rep(-gap, ncats), 
         1:ncats + halfwidth, col = lxcol)
    rect(rep(gap, ncats), 1:ncats - halfwidth, (rx + gap), 
         1:ncats + halfwidth, col = rxcol)
    if (show.values) {
      par(xpd = TRUE)
      lxt <- formatC(lx-rx, format = "f", digits = ndig) # modify text value beside the bar
      rxt <- formatC(rx-lx, format = "f", digits = ndig) # modify text value beside the bar
      text(-(gap + lx), 1:ncats, lxt, pos = 2, cex = labelcex)
      text(gap + rx, 1:ncats, rxt, pos = 4, cex = labelcex)
      par(xpd = FALSE)
    }
  }
  else {
    nstack <- dim(lx)[2]
    if (missing(lxcol)) 
      lxcol <- rainbow(nstack)
    if (missing(rxcol)) 
      rxcol <- rainbow(nstack)
    lxstart <- rxstart <- rep(gap, ncats)
    for (i in 1:nstack) {
      lxcolor <- rep(lxcol[i], ncats)
      rxcolor <- rep(rxcol[i], ncats)
      rect(-(lx[, i] + lxstart), 1:ncats - halfwidth, -lxstart, 
           1:ncats + halfwidth, col = lxcolor)
      rect(rxstart, 1:ncats - halfwidth, rx[, i] + rxstart, 
           1:ncats + halfwidth, col = rxcolor)
      lxstart <- lx[, i] + lxstart
      rxstart <- rx[, i] + rxstart
    }
  }
  return(oldmar)
}

ori<-c(48.36065574, 105.7377049, 49.18032787, 96.72131148, 73.7704918, 118.0327869, 98.36065574, 118.852459, 100, 77.86885246, 99.18032787, 67.21311475, 26.2295082, 102.4590164, 132.7868852, 153.2786885, 160.6557377, 26.2295082, 115.5737705, 106.557377, 163.1147541, 139.3442623, 85.24590164, 249.1803279, 188.5245902, 85.24590164, 134.4262295, 227.0491803, 117.2131148, 115.5737705, 175.4098361, 163.1147541, 102.4590164, 95.90163934, 94.26229508, 165.5737705, 238.5245902, 158.1967213, 186.8852459, 168.0327869, 184.4262295, 254.9180328, 260.6557377, 232.7868852)
gen<-c(48.96, 106.72, 49.84, 97.3, 74.16, 118.14, 98.46, 118.92, 100, 77.82, 99.08, 67.06, 26.04, 102.22, 132.14, 152.56, 159.64, 25.2, 114.38, 105.16, 161.46, 137.68, 83.24, 247.14, 186.38, 82.78, 131.8, 224.24, 114.24, 112.6, 172.34, 159.86, 99.2, 92.42, 90.72, 161.68, 233.38, 152.16, 180.34, 161.32, 176.92, 245.78, 251.34, 222.64)
# activity<-c("Airway-Stated","Breath-Sounds","Distal-Pulses","GCS-Stated","Pupil-Exam","Temperature","Warm-Blanket","Central-Pulses")
activity <- c("L_Visual_inspection_EAR", "Log_roll_BK", "R_Visual_inspection_EAR", "Visual_assessment_AA", "Verbal_assessment_AA", "Chest_Auscultation_BA", "L_otoscopy_EAR", "Left_pupil_PU", "Pt_arrival", "Rectal_BK", "Pt_departure", "Total_Verbalized_GCS", "R_visual_inspection_EY", "R_otoscopy_EAR", "Right_pupil_PU", "Visual_inspection_BK", "Visual_inspection_C", "L_visual_inspection_EY", "R_DP_PT_PC", "L_DP_PT_PC", "Palpation_F", "L_spine_BK", "Visual_inspection_N", "Visual_inspection_H", "Visual_inspection_F", "Visual_inspection_G", "Palpation_C", "Palpation_H", "Visual_inspection_NE", "C_spine_BK", "Visual_inspection_A", "T_spine_BK", "Palpation_NE", "Visual_inspection_M", "Stability_PE", "Palpation_A", "Palpation_LLE", "Palpation_LUE", "Palpation_RUE", "Visual_inspection_LUE", "Visual_inspection_RUE", "Visual_inspection_LLE", "Visual_inspection_RLE", "Palpation_RLE")
# col1<-color.gradient(c(0,0,0.5,1),c(0,0,0.5,1),c(1,1,0.5,1),18)
# col2<-color.gradient(c(1,1,0.5,1),c(0.5,0.5,0.5,1),c(0.5,0.5,0.5,1),18)
par(mar=my_function(ori,gen,labels=activity,
                     main="",laxlab=c(0,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270),raxlab=c(0,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270),  # step value of interval
                     gap=78,show.values=TRUE))
# output .eps plot
setEPS()
postscript("Heuristic_PyramidPlot.eps")
par(mar=my_function(ori,gen,labels=activity,
                     main="",laxlab=c(0,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270),raxlab=c(0,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270),  # step value of interval
                     gap=115,show.values=TRUE))
dev.off()