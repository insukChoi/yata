import {AxiosRequestConfig} from 'axios'

export const axiosRequestConfiguration: AxiosRequestConfig = {
  baseURL: 'http://localhost:8088/api',
  responseType: 'json',
  headers: {
    'Content-Type': 'application/json',
  },
}