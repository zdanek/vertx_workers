container.with {
    deployVerticle('pl.touk.alarmy.FastIndexRest')
    deployWorkerVerticle('pl.touk.alarmy.FastIndexWorker', 10)
}