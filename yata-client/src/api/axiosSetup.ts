import axios, {AxiosRequestConfig, AxiosInstance, AxiosPromise} from 'axios'

const initializeAxios = (config: AxiosRequestConfig): AxiosInstance => {
  const axiosInstance = axios.create(config);
  return axiosInstance
}

export default initializeAxios