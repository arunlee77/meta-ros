require ${COREBASE}/meta/recipes-core/images/core-image-minimal.bb

SUMMARY = "A small image just capable of starting core ROS."
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image
RREPLACES:${PN} = "connman"
PREFERRED_PROVIDER:virtual/kernel ??= "linux-imx"
PREFERRED_PROVIDER:u-boot = "u-boot-imx"
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += "kernel-modules"

IMAGE_INSTALL:remove = " connman"

IMAGE_INSTALL:append = " \
    ros-core \
    iw \
    networkmanager \
    networkmanager-nmcli \
    wpa-supplicant \
"
IMAGE_INSTALL:remove = "connman connman-client connman-conf"
